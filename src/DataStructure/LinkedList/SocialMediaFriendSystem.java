package DataStructure.LinkedList;


import java.util.Scanner;

class SocialMediaFriendSystem {

    static class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int friendId) {
            this.friendId = friendId;
        }
    }

    static class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friendHead;
        UserNode next;

        UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendHead = null;
        }
    }

    UserNode head = null;

    void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added");
    }

    UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friendHead = addFriendNode(u1.friendHead, id2);
        u2.friendHead = addFriendNode(u2.friendHead, id1);

        System.out.println("Friend connection added");
    }

    FriendNode addFriendNode(FriendNode head, int id) {
        FriendNode newNode = new FriendNode(id);
        newNode.next = head;
        return newNode;
    }

    void removeFriend(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friendHead = removeFriendNode(u1.friendHead, id2);
        u2.friendHead = removeFriendNode(u2.friendHead, id1);

        System.out.println("Friend connection removed");
    }

    FriendNode removeFriendNode(FriendNode head, int id) {
        if (head == null) return null;

        if (head.friendId == id)
            return head.next;

        FriendNode temp = head;
        while (temp.next != null && temp.next.friendId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    void displayFriends(int id) {
        UserNode user = findUserById(id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friendHead;
        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void mutualFriends(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        boolean found = false;

        for (FriendNode f1 = u1.friendHead; f1 != null; f1 = f1.next) {
            for (FriendNode f2 = u2.friendHead; f2 != null; f2 = f2.next) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("None");
        else
            System.out.println();
    }

    void searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }

    void displayUser(UserNode u) {
        System.out.println(
                "ID: " + u.userId +
                        ", Name: " + u.name +
                        ", Age: " + u.age
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaFriendSystem sm = new SocialMediaFriendSystem();
        int choice;

        do {
            System.out.println("\n--- Social Media Friend System ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Search User by ID");
            System.out.println("8. Count Friends of Each User");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("User 1 ID: ");
                    int u1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int u2 = sc.nextInt();
                    sm.addFriend(u1, u2);
                    break;

                case 3:
                    System.out.print("User 1 ID: ");
                    int r1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int r2 = sc.nextInt();
                    sm.removeFriend(r1, r2);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    sm.displayFriends(sc.nextInt());
                    break;

                case 5:
                    System.out.print("User 1 ID: ");
                    int m1 = sc.nextInt();
                    System.out.print("User 2 ID: ");
                    int m2 = sc.nextInt();
                    sm.mutualFriends(m1, m2);
                    break;

                case 6:
                    System.out.print("Enter Name: ");
                    sm.searchByName(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter User ID: ");
                    UserNode user = sm.findUserById(sc.nextInt());
                    if (user != null)
                        sm.displayUser(user);
                    else
                        System.out.println("User not found");
                    break;

                case 8:
                    sm.countFriends();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
