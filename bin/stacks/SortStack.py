def sort_stack(s1):
    """
    Sorts a stack such that the smallest items are on the top.
    Uses a temporary stack (s2) and recursion.
    """
    s2 = []

    sort_helper(s1, s2)



def sort_helper(s1, s2 ):
    # Base case: if s1 is empty, return
    if not s1:
        return

    # Pop the top element from s1
    temp = s1.pop()

    # Move elements from s2 to s1 until the correct position for `temp` is found
    while s2 and s2[-1] > temp:
        s1.append(s2.pop())

    # Place the temp element in s2
    s2.append(temp)

    # Recur for the rest of s1
    sort_helper(s1, s2)

    # Move all sorted elements back from s2 to s1
    if s2:
        s1.append(s2.pop())


# Example usage
if __name__ == "__main__":
    s1 = [3, 5, 1, 4, 2]  # Python list as a stack
    print("Original Stack:", s1)
    sort_stack(s1)
    print("Sorted Stack:", s1)


