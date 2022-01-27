package Data_Structure.Queue;

public class Main {
    public static void main(String[] args) {
        QueueLinkedList<String> list = new QueueLinkedList<>();
        list.offer("Dean");
        list.offer("Eggie");
        list.offer("Charles");
        System.out.println(list.peek());
        list.poll();
        list.poll();
        System.out.println(list.peek());


        QueueLinkedList li = new QueueLinkedList();
        li.offer(23);
        li.offer(33);
        li.offer(43);
        li.offer(53);

        System.out.println(li.peek());
        System.out.println(li.poll()); //todo why is priting null
        System.out.println(li.getSize_1());
    }

}
