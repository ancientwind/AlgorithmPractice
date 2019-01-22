package com.wayne.algo.binaryTree;

import java.util.*;

public class HuffmanTree {

    private HuffmanNode root;

    static final String leftCode = "0";
    static final String rightCode = "1";

    private Map<Integer, String> nodeCode = new HashMap<>();

    private List<HuffmanNode> initNodes() {
        List<HuffmanNode> nodes = new ArrayList<>();
        nodes.add(new HuffmanNode(1, 2));
        nodes.add(new HuffmanNode(2, 8));
        nodes.add(new HuffmanNode(3, 5));
        nodes.add(new HuffmanNode(4, 6));
        nodes.add(new HuffmanNode(5, 4));
        return nodes;
    }

    /**
     * build huffman tree
     *
     * @param huffmanNodeList
     */
    public void build(List<HuffmanNode> huffmanNodeList) {
        if (huffmanNodeList.size() == 1) {
            this.root = huffmanNodeList.get(0);

        } else if (huffmanNodeList.size() > 1) {
            HuffmanNode[] sortedHuffmanNodes = sortWeightedNodeList(huffmanNodeList);

            HuffmanNode leftLeaf = sortedHuffmanNodes[0];
            HuffmanNode rightLeaf = sortedHuffmanNodes[1];
            HuffmanNode parent = new HuffmanNode(leftLeaf, rightLeaf);

            huffmanNodeList.remove(leftLeaf);
            huffmanNodeList.remove(rightLeaf);
            huffmanNodeList.add(parent);

            build(huffmanNodeList);
        }
    }

    /**
     * encode each node of the huffman tree
     */
    public void encode(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }
        encode(root.getLeftChild(), leftCode + code);
        encode(root.getRightChild(), rightCode + code);
        if (root.isLeaf()) {
            this.nodeCode.put(root.getId(), code);
        }
    }

    public HuffmanNode[] sortWeightedNodeList(List<HuffmanNode> huffmanNodeList) {
        HuffmanNode[] sortedHuffmanNodes =
                huffmanNodeList.stream().sorted(Comparator.comparing(HuffmanNode::getWeight)).toArray(HuffmanNode[]::new);
        return sortedHuffmanNodes;
    }

    public void printTree(HuffmanNode root) {
        if (root != null) {
            System.out.println(root);
            if (root.hasLeft()) {
                printTree(root.getLeftChild());
            }
            if (root.hasRight()) {
                printTree(root.getRightChild());
            }
        }
    }

    public HuffmanNode getRoot() {
        return root;
    }

    public Map<Integer, String> getNodeCode() {
        return nodeCode;
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        List<HuffmanNode> nodeList = huffmanTree.initNodes();
        HuffmanNode[] nodes = huffmanTree.sortWeightedNodeList(nodeList);
        for (HuffmanNode node : nodes) {
            System.out.println(node);
        }

        System.out.println();
        System.out.println("Starting to build huffman tree...");
        huffmanTree.build(nodeList);

        huffmanTree.printTree(huffmanTree.getRoot());

        huffmanTree.encode(huffmanTree.getRoot(), "");
        System.out.println(huffmanTree.getNodeCode());
    }
}


