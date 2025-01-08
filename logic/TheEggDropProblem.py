# The Egg Drop Problem: There is a building of 100 floors. If an egg drops from the Nth floor or
# above, it will break. If it's dropped from any floor below, it will not break. You're given two eggs. Find
# N, while minimizing the number of drops for the worst case.


# when can run from 0 - 100 each floors by it will to much steps and ues only 1 egg
# so we know that first egg will use jump floor and the sec egg will be each floor one by one.
# we can do jump by 10. and then for egg 2 by 1
# let say on floor 40 it brack so egg 2 will run from 30-40 and see when and we see that egg 2 got to 40 also
#  so we did 4 for egg 1 and 10 for egg 2  = 14
# let say that floor is 80 - so it will be 8 for egg 1 and 10 for egg 2 = 18
# so it is not good we need to find less steps for worst.
# to balancing the two stages we need to lower the first 1 stage (egg1) each drop
# 10 , 19 , 27 ,35 ...  it will be 13.651 and it need to be int number so it will be 14 or 13
# if we use 13 it will not work will we will get 91 , less then 100
# so we use 14 = 105 work will.

def egg_drop(floors=100):
    drops = 0
    first_egg = 14
    increment = 14
    last_safe_floor = 0

    # First egg phase
    while first_egg <= floors:
        drops += 1
        if is_critical_floor(first_egg):
            break
        last_safe_floor = first_egg
        increment -= 1
        first_egg += increment

    # Second egg phase
    for floor in range(last_safe_floor + 1, first_egg):
        drops += 1
        if is_critical_floor(floor):
            return floor, drops

    return first_egg, drops



def is_critical_floor(floor, critical_floor=14):
    return floor >= critical_floor


critical_floor, total_drops = egg_drop()
print(f"Critical Floor: {critical_floor}, Total Drops: {total_drops}")