# The Apocalypse: In the new post-apocalyptic world, the world queen is desperately concerned
# about the birth rate. Therefore, she decrees that all families should ensure that they have one girl or
# else they face massive fines. If all families abide by this policy-that is, they have continue to have
# children until they have one girl, at which point they immediately stop-what will the gender ratio
# of the new generation be? (Assume that the odds of someone having a boy or a girl on any given
# pregnancy is equal.) Solve this out logically and then write a computer simulation of it.

# we know that get a boy or girl is 0.5
# also we know that when she get a girl she stop try
# if we look at a smaill city it will shift from 1:1 but when u look a a big number it will still be 1:1
# the % of get boy and then a boy again get lower by each boy so if we look at a big city it will be 1:1 
# Boys: 10051, Girls: 10000, Ratio (Boys:Girls): 1.01

import random


def simulate_apocalypse(families=10000):
    boys = 0
    girls = 0

    for _ in range(families):
        has_girl = False
        while not has_girl:
            if random.choice(['boy', 'girl']) == 'girl':
                girls += 1
                has_girl = True
            else:
                boys += 1

    return boys, girls


# Run the simulation
boys, girls = simulate_apocalypse(100)
print(f"Boys: {boys}, Girls: {girls}, Ratio (Boys:Girls): {boys / girls:.2f}")

