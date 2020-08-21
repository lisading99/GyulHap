package com.example.gyulhap;

import android.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GyulHapBoard {
    private List<GyulHapSquares> gyulHapSquaresList = new ArrayList<>();
    private GyulHapSquares[][] gyulHapBoard = new GyulHapSquares[3][3];
    private ArrayList<ArrayList<Integer>> gyulHapBoardAnswers = new ArrayList<>();
    private String level;

    public GyulHapBoard(String level) {
        this.level = level;
    }
    private void instantiateGyulHapSquares() {
        final GyulHapSquares squareGreenBlack = new GyulHapSquares("square", "green",
                "black",
                "android.resource://com.example.gyulhap/drawable/" +
                "square_green_black");
        GyulHapSquares triangleGreenBlack = new GyulHapSquares("triangle",
                "green", "black", "android.resource://" +
                "com.example.gyulhap/drawable/" + "triangle_green_black");
        GyulHapSquares circleGreenBlack = new GyulHapSquares("circle", "green",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "circle_green_black");
        GyulHapSquares squarePurpleBlack = new GyulHapSquares("square", "purple",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "square_purple_black");
        GyulHapSquares trianglePurpleBlack = new GyulHapSquares("triangle", "purple",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_purple_black");
        GyulHapSquares circlePurpleBlack = new GyulHapSquares("circle", "purple",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "circle_purple_black");
        GyulHapSquares squareBlueBlack = new GyulHapSquares("square", "blue",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "square_blue_black");
        GyulHapSquares triangleBlueBlack = new GyulHapSquares("triangle", "blue",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_blue_black");
        GyulHapSquares circleBlueBlack = new GyulHapSquares("circle", "blue",
                "black", "android.resource://com.example.gyulhap/drawable/" +
                "circle_blue_black");
        GyulHapSquares squareGreenWhite = new GyulHapSquares("square", "green",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "square_green_white");
        GyulHapSquares circleGreenWhite = new GyulHapSquares("circle", "green",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "circle_green_white");
        GyulHapSquares triangleGreenWhite = new GyulHapSquares("triangle", "green",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_green_white");
        GyulHapSquares squarePurpleWhite = new GyulHapSquares("square", "purple",
                "white","android.resource://com.example.gyulhap/drawable/" +
                "square_purple_white");
        GyulHapSquares circlePurpleWhite = new GyulHapSquares("circle", "purple",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "circle_purple_white");
        GyulHapSquares trianglePurpleWhite = new GyulHapSquares("triangle", "purple",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_purple_white");
        GyulHapSquares squareBlueWhite = new GyulHapSquares("square", "blue",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "square_blue_white");
        GyulHapSquares circleBlueWhite = new GyulHapSquares("circle", "blue",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "circle_blue_white");
        GyulHapSquares triangleBlueWhite = new GyulHapSquares("triangle", "blue",
                "white", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_blue_white");
        GyulHapSquares squareGreenGrey = new GyulHapSquares("square", "green",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "square_green_grey");
        GyulHapSquares circleGreenGrey = new GyulHapSquares("circle", "green",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "circle_green_grey");
        GyulHapSquares triangleGreenGrey = new GyulHapSquares("triangle", "green",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_green_grey");
        GyulHapSquares squarePurpleGrey = new GyulHapSquares("square", "purple",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "square_purple_grey");
        GyulHapSquares circlePurpleGrey = new GyulHapSquares("circle", "purple",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "circle_purple_grey");
        GyulHapSquares trianglePurpleGrey = new GyulHapSquares("triangle", "purple",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_purple_grey");
        GyulHapSquares squareBlueGrey = new GyulHapSquares("square", "blue",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "square_blue_grey");
        GyulHapSquares circleBlueGrey = new GyulHapSquares("circle", "blue",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "circle_blue_grey");
        GyulHapSquares triangleBlueGrey = new GyulHapSquares("triangle", "blue",
                "grey", "android.resource://com.example.gyulhap/drawable/" +
                "triangle_blue_grey");
        gyulHapSquaresList.add(squareGreenBlack);
        gyulHapSquaresList.add(circleGreenBlack);
        gyulHapSquaresList.add(triangleGreenBlack);
        gyulHapSquaresList.add(squarePurpleBlack);
        gyulHapSquaresList.add(circlePurpleBlack);
        gyulHapSquaresList.add(trianglePurpleBlack);
        gyulHapSquaresList.add(squareBlueBlack);
        gyulHapSquaresList.add(circleBlueBlack);
        gyulHapSquaresList.add(triangleBlueBlack);
        gyulHapSquaresList.add(squareGreenWhite);
        gyulHapSquaresList.add(circleGreenWhite);
        gyulHapSquaresList.add(triangleGreenWhite);
        gyulHapSquaresList.add(squarePurpleWhite);
        gyulHapSquaresList.add(circlePurpleWhite);
        gyulHapSquaresList.add(trianglePurpleWhite);
        gyulHapSquaresList.add(squareBlueWhite);
        gyulHapSquaresList.add(circleBlueWhite);
        gyulHapSquaresList.add(triangleBlueWhite);
        gyulHapSquaresList.add(squareGreenGrey);
        gyulHapSquaresList.add(circleGreenGrey);
        gyulHapSquaresList.add(triangleGreenGrey);
        gyulHapSquaresList.add(squarePurpleGrey);
        gyulHapSquaresList.add(circlePurpleGrey);
        gyulHapSquaresList.add(trianglePurpleGrey);
        gyulHapSquaresList.add(squareBlueGrey);
        gyulHapSquaresList.add(circleBlueGrey);
        gyulHapSquaresList.add(triangleBlueGrey);
    }

    private void createGyulHapBoard() {
        Random random = new Random();
        int randomInt;
        GyulHapSquares randomGyulHapSquare;
        instantiateGyulHapSquares();
        ArrayList<String> list = new ArrayList<>();

        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 3; col++) {
                randomInt = random.nextInt(27);
                randomGyulHapSquare = gyulHapSquaresList.get(randomInt);
                gyulHapBoard[row][col] = randomGyulHapSquare;
                list.add(randomGyulHapSquare.getShape());
                list.add(randomGyulHapSquare.getShapeColour());
                list.add(randomGyulHapSquare.getBkgColour());
            }
        }
        System.out.println(list);

    }

    private List<List<HashMap<String, Integer>>> getGyulHapPairs() {
        HashMap<String, Integer> firstPairMap = new HashMap<>();
        HashMap<String, Integer> secondPairMap = new HashMap<>();
        HashMap<String, Integer> thirdPairMap = new HashMap<>();
        List<List<HashMap<String, Integer>>> gyulHapPairsList =
                new ArrayList<>();
        ArrayList<ArrayList<Integer>> firstPairList = new ArrayList<>();
        int count = -1;
        int row, col;

        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                firstPairList.add(new ArrayList<Integer>(
                        Arrays.asList(row, col)));
                System.out.println(firstPairList);
            }
        }
        for (int i = 0; i < firstPairList.size(); i++) {
            for (int x = i + 1; x < firstPairList.size(); x++ ) {
                for (int y = x + 1; y < firstPairList.size(); y++) {
                    firstPairMap = new HashMap<>();
                    firstPairMap.put("row", firstPairList.get(i).get(0));
                    firstPairMap.put("col", firstPairList.get(i).get(1));
                    firstPairMap.put("index", i + 1);
                    secondPairMap = new HashMap<>();
                    secondPairMap.put("row", firstPairList.get(x).get(0));
                    secondPairMap.put("col", firstPairList.get(x).get(1));
                    secondPairMap.put("index", x + 1);
                    thirdPairMap = new HashMap<>();
                    thirdPairMap.put("row", firstPairList.get(y).get(0));
                    thirdPairMap.put("col", firstPairList.get(y).get(1));
                    thirdPairMap.put("index", y + 1);
                    gyulHapPairsList.add(new ArrayList<HashMap<String, Integer>>(Arrays.asList(
                            firstPairMap, secondPairMap, thirdPairMap
                    )));
                }
            }
        }
        return gyulHapPairsList;
    }

    private void solveGyulHapBoard() {
        List<List<HashMap<String, Integer>>> gyulHapPairs = getGyulHapPairs();
        gyulHapBoardAnswers = new ArrayList<>();
        GyulHapSquares firstSquare = null;
        GyulHapSquares secondSquare = null;
        GyulHapSquares thirdSquare = null;
        int firstRow, firstCol, secondRow, secondCol, thirdRow, thirdCol, firstIndex,
        secondIndex, thirdIndex;
        boolean isValidShape = false;
        boolean isValidShapeColour = false;
        boolean isValidBkgColour = false;
        boolean isValidCombination = false;


        for (int i = 0; i < gyulHapPairs.size(); i++) {
            firstRow = gyulHapPairs.get(i).get(0).get("row");
            firstCol = gyulHapPairs.get(i).get(0).get("col");
            firstIndex = gyulHapPairs.get(i).get(0).get("index");
            secondRow = gyulHapPairs.get(i).get(1).get("row");
            secondCol = gyulHapPairs.get(i).get(1).get("col");
            secondIndex = gyulHapPairs.get(i).get(1).get("index");
            thirdRow = gyulHapPairs.get(i).get(2).get("row");
            thirdCol = gyulHapPairs.get(i).get(2).get("col");
            thirdIndex = gyulHapPairs.get(i).get(2).get("index");

            firstSquare = gyulHapBoard[firstRow][firstCol];
            secondSquare = gyulHapBoard[secondRow][secondCol];
            thirdSquare = gyulHapBoard[thirdRow][thirdCol];

            isValidShape = (firstSquare.getShape().contentEquals(secondSquare.getShape()) &&
            secondSquare.getShape().contentEquals(thirdSquare.getShape())) ||
                     (! firstSquare.getShape().contentEquals(secondSquare.getShape())
                    && ! secondSquare.getShape().contentEquals(thirdSquare.getShape())
                    && ! thirdSquare.getShape().contentEquals(firstSquare.getShape()));
            isValidShapeColour = (firstSquare.getShapeColour().contentEquals(
                    secondSquare.getShapeColour()) &&
                    secondSquare.getShapeColour().contentEquals(thirdSquare.getShapeColour())) ||
                     (! firstSquare.getShapeColour().contentEquals(secondSquare.getShapeColour())
                            && ! secondSquare.getShapeColour().contentEquals(
                                    thirdSquare.getShapeColour()) &&
            ! thirdSquare.getShapeColour().contentEquals(firstSquare.getShapeColour()));
            isValidBkgColour = firstSquare.getBkgColour().contentEquals(
                    secondSquare.getBkgColour()) &&
                    secondSquare.getBkgColour().contentEquals(thirdSquare.getBkgColour()) ||
                     (! firstSquare.getBkgColour().contentEquals(secondSquare.getBkgColour())
                            && ! secondSquare.getBkgColour().contentEquals(
                                    thirdSquare.getBkgColour()) &&
                           ! thirdSquare.getBkgColour().contentEquals(firstSquare.getBkgColour()));
            isValidCombination = isValidShape && isValidBkgColour && isValidShapeColour;

            if (isValidCombination) {
                gyulHapBoardAnswers.add(new ArrayList<Integer>(Arrays.asList(firstIndex,
                        secondIndex, thirdIndex)));
            }
        }
    }

    private void createHardGyulHapBoard() {
        int gyulHapBoardAnswersSize;
        createGyulHapBoard();
        // solve the base gyul hap board
        solveGyulHapBoard();
        gyulHapBoardAnswersSize = gyulHapBoardAnswers.size();
        ArrayList<Integer> allSquaresList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6
        , 7, 8, 9));

        // found all squares that are not included in the answers
        for (int i = 0; i < gyulHapBoardAnswers.size(); i++) {
            for (int m = 0; m < 3; m++) {
                if (allSquaresList.contains(gyulHapBoardAnswers.get(i).get(m))) {
                    // remove integer from allSquaresList
                    allSquaresList.remove(gyulHapBoardAnswers.get(i).get(m));
                }
            }
        }
        int row, col;
        GyulHapSquares gyulHapSquare;
        // change the squares not included in the answer with a different square image
        for (int i = 0; i < allSquaresList.size(); i++) {
            if (allSquaresList.get(i) == 1 || allSquaresList.get(i) == 2 ||
                    allSquaresList.get(i) == 3) {
                row = 0;
            } else if (allSquaresList.get(i) == 4 || allSquaresList.get(i) == 5 ||
            allSquaresList.get(i) == 6) {
                row = 1;
            } else {
                row = 2;
            }
            col = (allSquaresList.get(i) % 3);
            switch (col) {
                case 1:
                    col = 0;
                case 2:
                    col = 1;
                case 0:
                    col = 2;
            }
            for (int m = 0; m < gyulHapSquaresList.size(); m++) {
                gyulHapSquare = gyulHapBoard[row][col];
                gyulHapBoard[row][col] = gyulHapSquaresList.get(m);
                solveGyulHapBoard();
                // keep the square that produces more possible answers
                if (gyulHapBoardAnswersSize < gyulHapBoardAnswers.size()) {
                    gyulHapBoardAnswersSize = gyulHapBoardAnswers.size();
                } else {
                    gyulHapBoard[row][col] = gyulHapSquare;
                }
            }
        }
    }

    public GyulHapSquares[][] getGyulHapBoard() {
        if (level.contentEquals("HARD")) {
            createHardGyulHapBoard();
        } else {
            createGyulHapBoard();
        }
        return gyulHapBoard;
    }

    public ArrayList<ArrayList<Integer>> getGyulHapBoardAnswers() {
        solveGyulHapBoard();
        return gyulHapBoardAnswers;
    }
}
