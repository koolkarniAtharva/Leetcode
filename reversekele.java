import java.util.*;
public class reversekele {

    // Iterative logic 
    public static void ReverseKElements(Queue<Integer> que ,int k) {
        if(que.isEmpty() == true || que.size() <k ){
            return ;
        }
        if(k == 0){
            return;
        }
        Stack<Integer> stack = new Stack<>();

       //enter it in stack and remove from queue
        for(int i =0; i< k;i++){
            stack.push(que.peek());
            que.remove();
        }

        // remove from stack push it in queue
        while(!stack.isEmpty()){
            que.add(stack.peek());
            stack.pop();    
        }

        // reomve the remaning elements from the queue and push them back ;
        int w = que.size()-k;
        for(int i =0;i<w;i++){
            que.add(que.peek());
            que.remove();
        }
        
        // Print the queue elements correctly
        for(int i = 0; i < que.size(); i++){
            System.out.print(que.peek() + " ");
            que.add(que.remove());
        }
    }

   
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        que.add(7);

        int k = 2;
        ReverseKElements(que,k);
        
    }
}