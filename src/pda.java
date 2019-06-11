import java.util.*;

class pda {

    private HashMap<String, Node> Pda;
    private String st;

    private Node Start;


    pda(ArrayList<String> input) {

        this.input = input;
        this.Pda = graphGenerator();
        st = "aaaabb";
        Start = Pda.get("#q0");
    }


    private ArrayList<String> input;


    private HashMap<String, Node> graphGenerator() {

        String t2 = " ";
        HashMap<String, Node> data = new HashMap<>();
        for (String s : input) {
            String[] temp = s.split(",");
            Node n = new Node(temp[0]);
            if (temp[0].contains("@")) {
                n.setInfinite(true);
            } else {
                n.setInfinite(false);
            }
            if (!t2.equals(temp[0])) {
                data.put(temp[0], n);
                t2 = temp[0];
            }

        }
        this.addChildren(data);
        return data;
    }


    //this function add children to each node simply define each node path with other node.
    private void addChildren(HashMap<String, Node> data) {
        for (String s : input) {
            String[] temp = s.split(",");
            if (!temp[4].equals("n")) {
                data.get(temp[0]).addEdge(temp[0], temp[1], temp[2], temp[3], temp[4]);
            }
        }
    }


    boolean hasPdaPath() {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        return checkStack(getStart(), 0, st.toCharArray(), stack);
    }

    private boolean checkStack(Node start, int i, char[] string, Stack<String> stack) {
        if (start.getEdges().isEmpty()) {
            return start.isInfinite();
        } else {
            Stack<String> tempStack = new Stack<>();
            tempStack.addAll(stack);
            String fuel = String.valueOf(string[i]);
            for (edges edge : start.getEdges()) {
                var index = i + 1 < string.length ? i + 1 : i;
                if (edge.getAlphabet().equals("&")) {
                    if (stack.lastElement().equals(edge.getPopTop())) {
                        stack.pop();
                        if (!edge.getPushTop().equals("&")) {
                            stack.push(edge.getPushTop());
                        }
                        if (checkStack(this.Pda.get(edge.getDestination()), index, string, stack)) {
                            return true;
                        }
                        stack.clear();
                        stack.addAll(tempStack);
                    } else if (edge.getPopTop().equals("&")) {
                        if (!edge.getPushTop().equals("&")) {
                            stack.push(edge.getPushTop());
                        }
                        if (checkStack(this.Pda.get(edge.getDestination()), i, string, stack)) {
                            return true;
                        }
                        stack.clear();
                        stack.addAll(tempStack);
                    }
                } else {
                    if (edge.getAlphabet().equals(fuel)) {
                        if (stack.lastElement().equals(edge.getPopTop())) {
                            stack.pop();
                            if (!edge.getPushTop().equals("&")) {
                                stack.push(edge.getPushTop());
                            }
                            if (checkStack(this.Pda.get(edge.getDestination()), index, string, stack)) {
                                return true;
                            }
                            stack.clear();
                            stack.addAll(tempStack);
                        }
                        if (edge.getPopTop().equals("&")) {
                            if (!edge.getPushTop().equals("&")) {
                                stack.push(edge.getPushTop());
                            }
                            if (checkStack(this.Pda.get(edge.getDestination()), index, string, stack)) {
                                return true;
                            }
                            stack.clear();
                            stack.addAll(tempStack);
                        }
                    }
                }
            }
        }
        return (start.isInfinite());

    }


    private Node getStart() {
        return Start;
    }


}