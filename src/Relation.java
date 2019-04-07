import java.io.*;

public class Relation {
    public int Matrix[];
    private int dimension;

    //Constructor with a string of the filename.
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
        boolean check = true;

        for (int i = 0; i < Matrix.length; i = i + dimension + 1) {
            if (Matrix[i] != 1)
                check=false;
        }
        return check;
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

    //Judge whether the matrix is asymmetric or not.
    public boolean isAsymmetric() {
        if (!isSymmetric()) {
            for (int i = 0; i < dimension; i++) {
                if (Matrix[i * dimension + i] == 1)
                    return false;
            }
            return true;
        } else return false;
    }

    //Judge whether the matrix is antisymmetric or not.
    public boolean isAntisymmetric() {
        boolean check = true;

        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {

                if (Matrix[r * dimension + c] == Matrix[c * dimension + r] &&
                        r * dimension + c != c * dimension + r)
                    check = false;
            }
        }

        return check;
    }

    //Judge whether the matrix is transitive or not.
    public boolean isTransitive() {
        boolean check = true;

        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {

                if (Matrix[r * dimension + c] == 1) {

                    for (int k = 0; k < dimension; k++) {

                        if (Matrix[c * dimension + k] == 1) {
                            if (Matrix[r * dimension + k] != 1)
                                check = false;
                        }

                    }

                }

            }
        }

        return check;
    }

    //The getter for dimension.
    public int getDimension() {
        return dimension;
    }
}
