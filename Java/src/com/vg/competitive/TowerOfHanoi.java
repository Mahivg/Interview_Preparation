package com.vg.competitive;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * 1) Only one disk can be moved at a time.
 * 2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack
 *      i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * 3) No disk may be placed on top of a smaller disk.
 * Ref : https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 */

public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        int n = 4;
        toh.moveDesks(n, 'A', 'C', 'B');
    }

    private void moveDesks(int n, char fromDesk, char toDesk, char auxDesk) {
        if(n == 1) {
            System.out.println("Moving desk 1 from " + fromDesk + " to " + toDesk);
            return;
        }
        moveDesks(n-1, fromDesk, auxDesk, toDesk);
        System.out.println("Moving desk " + n + " from " + fromDesk + " to " + toDesk);
        moveDesks(n-1, auxDesk, toDesk, fromDesk);
    }
}
