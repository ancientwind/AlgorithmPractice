package com.wayne.algo.binaryTree;

/**
 * @author 212331901
 * @date 2019/1/18
 */
class HuffmanNode {
    /** id for temporary Node in each inner build */
    static int tempNodeID = 100;
    private int id;
    private int weight;
    private HuffmanNode leftChild;
    private HuffmanNode rightChild;

    public HuffmanNode(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public HuffmanNode(HuffmanNode leftChild, HuffmanNode rightChild) {
        this.id = getTempNodeID();
        this.weight = leftChild.getWeight() + rightChild.getWeight();
        if (leftChild.getWeight() < rightChild.getWeight()) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        } else if (leftChild.getWeight() > rightChild.getWeight()) {
            this.leftChild = rightChild;
            this.rightChild = leftChild;
        }
    }

    public HuffmanNode(int id, int weight, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.id = id;
        this.weight = weight;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    static int getTempNodeID() { return tempNodeID++; }

    public HuffmanNode copy() {
        return new HuffmanNode(this.getId(), this.getWeight(), this.getLeftChild(), this.getRightChild());
    }

    public boolean isLeaf() {
        return this.getLeftChild() == null && this.getRightChild() == null;
    }

    public boolean hasLeft() {
        return this.getLeftChild() != null;
    }

    public boolean hasRight() {
        return this.getRightChild() != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "id=" + id +
                ", weight=" + weight +
                ", leftChild=" + (leftChild == null ? "null" : leftChild.getId()) +
                ", rightChild=" + (rightChild == null ? "null" : rightChild.getId()) +
                '}';
    }
}
