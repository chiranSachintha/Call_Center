import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {
    private static final int num_Levels = 3;
    private static final int num_Respondents = 5;
    private static final int num_Managers = 3;
    private static final int num_Directors = 2;

    ArrayList<Employee>[] employLevels = new ArrayList[num_Levels];
    Queue<Call>[] callQueue = new LinkedList[num_Levels];

    public CallHandler(){
        ArrayList<Employee> respondents =new ArrayList<>(num_Respondents);
        for(int i = 0; i<num_Respondents;i++){
            respondents.add(new Respondent());
        }
        employLevels[0] = respondents;

        ArrayList<Employee> managers = new ArrayList<>(num_Managers);
        for(int  i = 0; i< num_Managers;i++){
            managers.add(new Manager());
        }
        employLevels[1] = managers;

        ArrayList<Employee> directors = new ArrayList<>(num_Directors);
        for(int i = 0; i<num_Directors; i++){
            directors.add(new Director());
        }
        employLevels[2] = directors;

    }
    public Employee getCallHandler(Call call){
        for(int level = call.getRank(); level < num_Levels-1;level++){
            ArrayList<Employee> employeeLevel = employLevels[level];
            for(Employee emp:employeeLevel){
                if(emp.free){
                    return emp;
                }
            }
        }
        return null;

    }
    public void disPatchCall(Call call){
        Employee emp = getCallHandler(call);
        if(emp != null){
            emp.receiveCall(call);
        }else{
            call.reply("please wait");
            callQueue[call.getRank()].add(call);
        }

    }

    public void getNextCall(Employee emp){
        for(int rank = emp.getRank();rank >= 0;rank++){
            Queue<Call> queue = callQueue[rank];
            Call call = queue.poll();
            if(call != null){
                emp.receiveCall(call);
                return;

            }
        }
    }
}
