package AddTwoNumbers;

public class AddTwoNumbers {
    public static void main(String... args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(1);

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println(res.val);

    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
//1 只需要编写核心的处理逻辑即可 TODO 基本功能已经实现了，可以优化一波

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        while (l1 != null || l2 != null) {
            int tempRes;
            if (l1 == null) {
                tempRes = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                tempRes = l1.val;
                l1 = l1.next;
            } else {
                tempRes = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            tempRes += tempNode.val;
            // 处理计算结果
            if (tempRes > 9) {
                tempRes = tempRes - 10;
                tempNode.val = tempRes;
                tempNode.next = new ListNode(1);
            }else {
                tempNode.val = tempRes;
            }
            if (tempNode.next == null && (l1 != null || l2 != null)) {
                tempNode.next = new ListNode(0);
            }
            //结果列表向后移动
            tempNode = tempNode.next;
        }
        //将多出来的位数加入结果中
        return result;
    }
}
