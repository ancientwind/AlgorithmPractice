package com.wayne.algo.recursion;

public class HanoiTower {

    public static void main(String[] args) {

        HanoiTower tower = new HanoiTower();
        tower.doTowers(3, 'A', 'B', 'C');
    }

    /**
     *
     * Suppose disks are marked from 1 to N continuously
     *
     * @param topN number of disks to move
     * @param from Tower A, source
     * @param media Tower B, as media
     * @param to Tower C, destination
     */
    public void doTowers(int topN, char from, char media, char to) {
        if (topN == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doTowers(topN - 1, from, to, media); // put top (n-1) disks to media, to will be act as media
            System.out.println("Disk " + topN + " from " + from + " to " + to); // put n disk to destination
            doTowers(topN -1, media, from, to); // put disk in media --> to
        }
    }
}
