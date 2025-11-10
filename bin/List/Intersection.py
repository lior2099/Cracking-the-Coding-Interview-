
# Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
# node. Note that the intersection is defined based on reference, not value. That is, if the kth
# node of the first linked list is the exact same node (by reference) as the jth node of the second
# linked list, then they are intersecting.

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


def get_size(node):
    """Returns the size of the linked list starting from the given node."""
    size = 0
    while node:
        size += 1
        node = node.next
    return size


def find_intersection(n1, n2):
    """
    Finds the intersection point of two singly linked lists.
    Returns the intersecting node if it exists, otherwise None.
    """
    size1, size2 = get_size(n1), get_size(n2)

    # Align the two lists by skipping extra nodes in the longer list
    if size1 > size2:
        n1 = advance_by(n1, size1 - size2)
    else:
        n2 = advance_by(n2, size2 - size1)

    # Traverse both lists together to find the intersection
    while n1 and n2:
        if n1 == n2:
            return n1
        n1, n2 = n1.next, n2.next

    return None


def advance_by(node, steps):
    """Advances a node by the given number of steps."""
    for _ in range(steps):
        node = node.next
    return node


def test_find_intersection(head1, head2, test_case):
    """Tests the find_intersection function and prints the result."""
    intersection = find_intersection(head1, head2)
    print(f"{test_case}:")
    if intersection:
        print(f"  Intersection at node with value: {intersection.value}")
    else:
        print("  No intersection found.")


if __name__ == "__main__":
    # Test case 1: Intersection at the middle
    common1 = Node(8)
    common1.next = Node(10)

    head1a = Node(3)
    head1a.next = Node(6)
    head1a.next.next = common1

    head2a = Node(4)
    head2a.next = common1

    test_find_intersection(head1a, head2a, "Test Case 1")

    # Test case 2: Intersection at the end
    common2 = Node(15)

    head1b = Node(7)
    head1b.next = Node(12)
    head1b.next.next = common2

    head2b = Node(5)
    head2b.next = common2

    test_find_intersection(head1b, head2b, "Test Case 2")

    # Test case 3: No intersection
    head1c = Node(1)
    head1c.next = Node(2)
    head1c.next.next = Node(3)

    head2c = Node(4)
    head2c.next = Node(5)
    head2c.next.next = Node(6)

    test_find_intersection(head1c, head2c, "Test Case 3")

    # Test case 4: Longer lists with intersection
    common3 = Node(20)
    common3.next = Node(25)

    head1d = Node(11)
    head1d.next = Node(12)
    head1d.next.next = Node(13)
    head1d.next.next.next = common3

    head2d = Node(14)
    head2d.next = Node(15)
    head2d.next.next = common3

    test_find_intersection(head1d, head2d, "Test Case 4")
