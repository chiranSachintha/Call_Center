public class Call {

    private int rank = 0;
    private String caller;
    private Employee handler;

    public Call(String caller){
        this.caller = caller;
    }
    public void reply(String message){
        System.out.println(message);

    }
    public String getCaller(){
        return this.caller;
    }
    public void disconnect(){

    }
    public int getRank(){
        return this.rank;
    }
}
