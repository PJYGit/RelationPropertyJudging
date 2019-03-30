public class Main {
    public static void main(String args[]) {
        Relation relation = new Relation("test1.txt");
        System.out.print(relation.dimension + "\n");
        relation.printMatrix();

        System.out.println("This relation is "+(relation.isReflexive()?"reflexive":"not reflexive"));
        System.out.println("This relation is "+(relation.isSymmetric()?"symmetric":"asymmetric"));
        System.out.println("This relation is "+(relation.isAntisymmetric()?"antisymmetric":"not antisymmetric"));
        System.out.println("This relation is "+(relation.isTransitive()?"transitive":"not transitive"));
    }
}
