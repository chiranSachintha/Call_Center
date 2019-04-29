public class Employee {
    private int rank;
    boolean free = true;
    CallHandler callHandler;

    public Employee(int rank){
        this.rank = rank;
    }

    public void receiveCall(Call call){
        free = false;
    }
    public void callHandled(Call call){
        call.disconnect();
        free = true;
        callHandler.getNextCall(this);
    }
    public int getRank(){
        return this.rank;
    }

}
