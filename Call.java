public class Call {

    private int rank = 0;
    private String caller;
    private Employee handler;

    public Call(String caller){
        this.caller = caller;
    }
    public void reply(String message){

    }
    public void disconnect(){

    }
    public int getRank(){
        return this.rank;
    }
}
