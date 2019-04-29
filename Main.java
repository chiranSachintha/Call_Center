public class Main {
    public static void main(String[] args){
        CallHandler callHandler = new CallHandler();
        for(int i = 1; i<=15; i++){
            Call call =new Call(String.valueOf(i));
            //Employee emp = callHandler.getCallHandler(call);
            System.out.println(call.getCaller());

            callHandler.disPatchCall(call);
            //System.out.println("finished");
        }


    }
}
