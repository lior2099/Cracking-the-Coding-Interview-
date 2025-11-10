#     Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
#     beginning of the loop.
#     DEFINITION
#     Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
#     as to make a loop in the linked list.
#
#     EXAMPLE
#     Input:  A -> B -> C -> D -> E -> C [the same C as earlier]
#     Output:  C
#

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

def find_loop(head):

    slow = head
    fast = head

    # find loop
    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next

        if fast == slow:
            break
    # if no loop found
    if fast is None or fast.next is None:
        return Node

    # find the loop point
    slow = head
    while slow != fast:
        slow = slow.next
        fast = fast.next

    return slow

