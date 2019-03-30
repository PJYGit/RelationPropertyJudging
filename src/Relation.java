import java.io.*;

public class Relation {
    public int Matrix[];
    public int dimension;

    public Relation(String filename) {
        readMatrix(filename);
    }

    //Read the matrix from the standard file.
    public void readMatrix(String file) {
        File open = new File(file);
        BufferedReader reader = null;

        if (!open.exists()) {
            System.out.println("Can't open file!");
            System.exit(0);
        }

        try {
            reader = new BufferedReader(new FileReader(open));
            String textLine = reader.readLine();
            String temp = "", temp1;
            int row, col;

            dimension = Integer.parseInt(textLine);
            Matrix = new int[dimension * dimension];

            textLine = reader.readLine();
            while (textLine != null) {
                temp = temp + textLine;
                textLine = reader.readLine();
            }

            reader.close();

            temp1 = temp.replaceAll("\\s*", "");

            int i = 0;

            for (row = 0; row < dimension; row++) {
                for (col = 0; col < dimension; col++) {
                    Matrix[row * dimension + col] = (int) temp1.charAt(i) - (int) ('0');
                    i++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Print the matrix.
    public void printMatrix() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(Matrix[i * dimension + j] + "  ");
            }
            System.out.print('\n');
        }
    }

    //Judge whether the matrix is reflexive or not.
    public boolean isReflexive() {
        int oneCount = 0;

        for (int i = 0; i < Matrix.length; i = i + dimension + 1) {
            if (Matrix[i] == 1)
                oneCount++;
        }
        if (oneCount == dimension) return true;
        else return false;
    }

    //Judge whether the matrix is symmetric or not.
    public boolean isSymmetric() {
        boolean check = true;

        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                if (Matrix[r * dimension + c] != Matrix[c * dimension + r])
                    check = false;
            }
        }

        return check;
    }

    //Judge whether the matrix is antisymmetric or not.
    public boolean isAntisymmetric(){
        boolean check = true;

        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {

                if (Matrix[r * dimension + c] == Matrix[c * dimension + r] &&
                        r * dimension + c == c * dimension + r){
                    if (Matrix[c * dimension + r] == 0)
                        check = false;
                }
                else if (Matrix[r * dimension + c] == Matrix[c * dimension + r] &&
                        r * dimension + c != c * dimension + r)
                    check = false;
            }
        }

        return check;
    }

    //Judge whether the matrix is transitive or not.
    public boolean isTransitive(){
        boolean check = true;

        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                if (Matrix[r * dimension + c] == 1){

                }
            }
        }

        return check;
    }
}
