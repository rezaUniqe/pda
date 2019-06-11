class edges {
    private String source;
    private String destination;
    private String PushTop;
    private String PopTop;
    private String Alphabet;


    edges(String source, String At, String popTop, String pushTop, String destination) {
        this.source = source;
        this.destination = destination;
        this.PopTop = popTop;
        this.PushTop = pushTop;
        this.Alphabet=At;
    }




    String getDestination() {
        return destination;
    }



    String getPushTop() {
        return PushTop;
    }


    String getPopTop() {
        return PopTop;
    }


    String getAlphabet() {
        return Alphabet;
    }

}
