package DataStructure.LinkedList;

import java.util.Scanner;

class RoundRobinScheduling {

    static class Node {
        int pid;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime = 0;
        int turnaroundTime = 0;
        Node next;

        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
        }
    }

    Node head = null;

    void addProcess(int pid, int bt, int priority) {
        Node newNode = new Node(pid, bt, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    void removeProcess(int pid) {
        if (head == null) return;

        Node curr = head;
        Node prev = null;

        do {
            if (curr.pid == pid) {
                if (curr == head) {
                    Node last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue");
            return;
        }

        Node temp = head;
        do {
            System.out.print(
                    "[PID:" + temp.pid +
                            " RT:" + temp.remainingTime + "] -> "
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }

    void roundRobin(int timeQuantum) {
        int time = 0;
        int totalWT = 0;
        int totalTAT = 0;
        int count = 0;

        Node curr = head;

        while (head != null) {
            displayProcesses();

            if (curr.remainingTime > timeQuantum) {
                curr.remainingTime -= timeQuantum;
                time += timeQuantum;
            } else {
                time += curr.remainingTime;
                curr.remainingTime = 0;

                curr.turnaroundTime = time;
                curr.waitingTime = curr.turnaroundTime - curr.burstTime;

                totalWT += curr.waitingTime;
                totalTAT += curr.turnaroundTime;
                count++;

                int pidToRemove = curr.pid;
                curr = curr.next;
                removeProcess(pidToRemove);
                continue;
            }
            curr = curr.next;
        }

        System.out.println("\n--- Scheduling Completed ---");
        System.out.println("Average Waiting Time = " + (double) totalWT / count);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduling rr = new RoundRobinScheduling();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter Process ID: ");
            int pid = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Enter Priority: ");
            int p = sc.nextInt();

            rr.addProcess(pid, bt, p);
        }

        System.out.print("\nEnter Time Quantum: ");
        int tq = sc.nextInt();

        System.out.println("\n--- Starting Round Robin Scheduling ---");
        rr.roundRobin(tq);

        sc.close();
    }
}
