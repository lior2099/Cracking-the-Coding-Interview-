def is_rotation(s1, s2):
    """
    Check if s2 is a rotation of s1 using one call to substring (in operator).
    """
    if not s1 or not s2 or len(s1) != len(s2):
        return False
    concatenated = s1 + s1
    return s2 in concatenated  # Using 'in' as substring checker


if __name__ == "__main__":
    s1 = "waterbottle"
    s2 = "erbottlewat"

    if is_rotation(s1, s2):
        print(f'"{s2}" is a rotation of "{s1}"')
    else:
        print(f'"{s2}" is not a rotation of "{s1}"')
