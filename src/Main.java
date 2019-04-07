public class Main {
    public static void main(String args[]) {

        Relation relation = new Relation("test.txt");
        System.out.print("The dimension of the matrix of this relation is: " + relation.getDimension() + "\n");
        System.out.println("Here is the matrix:");
        relation.printMatrix();

        System.out.println("Here are the properties of this relation:");

        System.out.println("This relation is " + (relation.isReflexive() ? "reflexive" : "not reflexive"));
        System.out.println("This relation is " + (relation.isSymmetric() ? "symmetric" : "not symmetric"));
        System.out.println("This relation is " + (relation.isAsymmetric() ? "asymmetric" : "not asymmetric"));
        System.out.println("This relation is " + (relation.isAntisymmetric() ? "antisymmetric" : "not antisymmetric"));
        System.out.println("This relation is " + (relation.isTransitive() ? "transitive" : "not transitive"));
    }
}
