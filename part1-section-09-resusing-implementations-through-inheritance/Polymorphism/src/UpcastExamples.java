// Tree is the base class
class Tree {
    String type = "unknown";

    String getTreeString() {
        return "Tree";
    }
}

// DeciduousTree is a subclass of Tree
class DeciduousTree extends Tree {
    String type = "deciduous";

    String getTreeString() {
        return "Leafy Tree";
    }
}

// FruitTree is a subclass of Tree
class FruitTree extends Tree {
    String type = "fruit";

    String getTreeString() {
        return "Fruit Tree";
    }
}

public class UpcastExamples {
    public static void main(String[] args) {

        UpcastExamples upex = new UpcastExamples();

        // Create two specific trees
        DeciduousTree mapleTree = new DeciduousTree();
        FruitTree appleTree = new FruitTree();

        // we upcast deciduousTree to its parent class
        Tree genericTree = (Tree) mapleTree;

        // Print mapleTree's type
        System.out.println("Tree type = " + mapleTree.type);

        // Let's upcast to use the generic Tree's type..
        System.out.println("Tree type = " + ((Tree) mapleTree).type);

        // Upcasting to pass object as a parameter
        // note: Casting 'mapleTree' to 'Tree' is redundant
        upex.printTreeType((Tree) mapleTree);
    }

    public void printTreeType(Tree tree) {
        System.out.println("Tree type = " + tree.getTreeString());
    }
}