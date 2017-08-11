package org.inventivetalent.chromaclient.effects;

import org.inventivetalent.chromaclient.Util;

import java.awt.*;

public abstract class ColorMatrixAbstract {

	private       int[][] matrix;
	private final int     rows;
	private final int     columns;

	public ColorMatrixAbstract(int[][] matrix, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		if (matrix.length != rows) {
			throw new IllegalArgumentException("array must have a length of " + rows + " rows");
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != columns) {
				throw new IllegalArgumentException("array must have a length of " + columns + " columns, invalid array at index " + i);
			}
		}

		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColor(int i, int bgr) {
		byte hi = Util.hiByte(i);
		byte lo = Util.loByte(i);
		if (hi < 0 || hi > rows) { return; }
		if (lo < 0 || lo > columns) { return; }
		matrix[hi][lo] = bgr;
	}

	public void setColor(int i, Color color) {
		setColor(i, Util.rgbToBgr(color.getRGB()));
	}

	public void setColor(int x, int y, int bgr) {
		if (x < 0 || x > columns) { throw new IllegalArgumentException("Invalid x position, must be 0 > x < " + columns); }
		if (y < 0 || y > rows) { throw new IllegalArgumentException("Invalid y position, must be 0 > x < " + columns); }
		this.matrix[y][x] = bgr;
	}

	public void setColor(int x, int y, Color color) {
		setColor(x, y, Util.rgbToBgr(color.getRGB()));
	}

	public void fill(int bgr) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.matrix[i][j] = bgr;
			}
		}
	}

	public void fill(Color color) {
		fill(Util.rgbToBgr(color.getRGB()));
	}

	public void fillRow(int row, int bgr) {
		if (row < 0 || row > rows) { throw new IllegalArgumentException("Invalid row, must be 0 > row < " + rows); }
		for (int i = 0; i < columns; i++) {
			matrix[row][i] = bgr;
		}
	}

	public void fillRow(int row, Color color) {
		fillRow(row, Util.rgbToBgr(color.getRGB()));
	}

	public void fillColumn(int column, int bgr) {
		if (column < 0 || column > columns) { throw new IllegalArgumentException("Invalid column, must be 0 > column < " + columns); }
		for (int i = 0; i < rows; i++) {
			matrix[i][column] = bgr;
		}
	}

	public void fillColumn(int column, Color color) {
		fillColumn(column, Util.rgbToBgr(color.getRGB()));
	}

}
