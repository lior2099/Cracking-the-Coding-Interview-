def set_zeroes(matrix):
    """
    Given an MxN matrix, if an element is 0, set its entire row and column to 0.
    Modifies the matrix in place.
    """
    if not matrix or not matrix[0]:
        return

    rows = len(matrix)
    cols = len(matrix[0])

    zero_rows = [False] * rows  # Track rows to zero out
    zero_cols = [False] * cols  # Track columns to zero out

    # Identify rows and columns that need to be zeroed
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == 0:
                zero_rows[i] = True
                zero_cols[j] = True

    # Set rows to zero
    for i in range(rows):
        if zero_rows[i]:
            for j in range(cols):
                matrix[i][j] = 0

    # Set columns to zero
    for j in range(cols):
        if zero_cols[j]:
            for i in range(rows):
                matrix[i][j] = 0


def print_matrix(matrix):
    """Utility function to print a matrix."""
    for row in matrix:
        print(" ".join(map(str, row)))


if __name__ == "__main__":
    matrix = [
        [1, 1, 1, 1, 1, 1],
        [1, 0, 1, 1, 1, 1],
        [1, 1, 1, 1, 0, 1],
        [1, 1, 1, 1, 1, 1]
    ]

    print("Original Matrix:")
    print_matrix(matrix)

    set_zeroes(matrix)
    print("\nAfter Zero Matrix:")
    print_matrix(matrix)
