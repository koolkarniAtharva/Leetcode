import java.util.*;
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>st = new Stack<>();

        ListNode curr = head;
        
        while(curr != null){
            st.push(curr.val);

            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            if(curr.val != st.peek()){
                return false;
            }
            st.pop();
            curr = curr.next;
        }
        return true;
    }
}