package com.interview.practice;


import java.util.HashSet;
import java.util.Set;

interface Robot {
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}

public class RobotRoomCleaning {
     static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Up, Right, Down, Left
    
    public void cleanRoom(Robot robot) {
        dfs(robot, new HashSet<>(), 0, 0, 0); // Start DFS from position (0, 0) facing up
    }
    
    private void dfs(Robot robot, Set<String> visited, int row, int col, int dir) {
        String key = row + "," + col;
        if (visited.contains(key)) {
            return; // Skip if cell has already been visited
        }
        
        robot.clean(); // Clean the current cell
        visited.add(key); // Mark the cell as visited
        
        // Explore all four directions (up, right, down, left)
        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4; // Update direction (turn left or right)
            int newRow = row + DIRECTIONS[newDir][0]; // Calculate new row
            int newCol = col + DIRECTIONS[newDir][1]; // Calculate new column
            
            // Move the robot to the new cell if it's not a wall and not visited
            if (robot.move()) {
                dfs(robot, visited, newRow, newCol, newDir); // Recursively explore the new cell
                backtrack(robot); // Backtrack to the previous cell
            }
            
            robot.turnRight(); // Turn right for next direction exploration
        }
    }
    
    // Backtrack to the previous cell
    private void backtrack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move(); // Move back
        robot.turnRight();
        robot.turnRight();
    }
    
    public static void main(String[] args) {
        // Example usage: Creating a MockRobot for demonstration
        MockRobot robot = new MockRobot();
        RobotRoomCleaning cleaner = new RobotRoomCleaning();
        cleaner.cleanRoom(robot);
    }
}

// MockRobot class for testing purposes
class MockRobot implements Robot {
    private int[][] grid = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}
    };

    private int row = 0;
    private int col = 0;
    private int direction = 0; // 0: up, 1: right, 2: down, 3: left

    @Override
    public boolean move() {
        int newRow = row + RobotRoomCleaning.DIRECTIONS[direction][0];
        int newCol = col + RobotRoomCleaning.DIRECTIONS[direction][1];
        if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
            return false; // Cannot move to the new cell (hit a wall)
        }
        row = newRow;
        col = newCol;
        return true; // Successfully moved to the new cell
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4; // Turn left (90 degrees counterclockwise)
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4; // Turn right (90 degrees clockwise)
    }

    @Override
    public void clean() {
        grid[row][col] = 2; // Mark the current cell as cleaned
        System.out.println("Cleaning cell: [" + row + ", " + col + "]");
    }
}
