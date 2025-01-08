# Poison: You have 1000 bottles of soda, and exactly one is poisoned. You have 10 test strips which
# can be used to detect poison. A single drop of poison will turn the test strip positive permanently.
# You can put any number of drops on a test strip at once and you can reuse a test strip as many times
# as you'd like (as long as the results are negative). However, you can only run tests once per day and
# it takes seven days to return a result. How would you figure out the poisoned bottle in as few days
# as possible?
# FOLLOW UP
# Write code to simulate your approach.

# let do it the  loogic way
# u split the bootle to gruop of 90 each and run it with the 10 test - so it will be 0 - 900  and 900-1000 will not be test
# we found the gruop that have the poison and then spilt it to gruop of 9 each 9*9 = 81 and we left with 82-90
# then we tun the test on each 1 and if it
# will take 3 week

# we can do better  by use binary number we have 10 test so it is 2^10 = 1024
# each test will be a binary number and we run all of them on the same day do it will take 7 days.

class Bottle:
    def __init__(self, bottle_id):
        self.bottle_id = bottle_id

    def get_id(self):
        return self.bottle_id


class TestStrip:
    def __init__(self, strip_id):
        self.strip_id = strip_id
        self.drops = []

    def add_drop_on_day(self, day, bottle):
        self.drops.append((day, bottle))

    def is_positive_on_day(self, day, poisoned_bottle):
        # Simulate test result: Check if the poisoned bottle is on this strip
        return any(bottle.get_id() == poisoned_bottle for test_day, bottle in self.drops if test_day == day)

    def get_id(self):
        return self.strip_id


def run_tests(bottles, test_strips):
    print("Running tests...")
    for bottle in bottles:
        bottle_id = bottle.get_id()
        bit_index = 0
        while bottle_id > 0:
            if bottle_id & 1:
                test_strips[bit_index].add_drop_on_day(0, bottle)
            bit_index += 1
            bottle_id >>= 1


def get_positive_on_day(test_strips, day, poisoned_bottle):
    positive = []
    print("Reading positive strips...")
    for test_strip in test_strips:
        if test_strip.is_positive_on_day(day, poisoned_bottle):
            print(f"Test strip {test_strip.get_id()} is positive")
            positive.append(test_strip.get_id())
    return positive


def set_bits(positive):
    result = 0
    for bit_index in positive:
        result |= (1 << bit_index)  # Set the corresponding bit
    print(f"Reconstructed binary result: {bin(result)}")
    return result


def find_poisoned_bottle(bottles, test_strips, poisoned_bottle):
    run_tests(bottles, test_strips)
    positive = get_positive_on_day(test_strips, 0, poisoned_bottle)  # Simulate results for day=0
    return set_bits(positive)


# Simulation
num_bottles = 1000
num_strips = 10

# Assign a random poisoned bottle
import random
poisoned_bottle = random.randint(0, num_bottles - 1)
print(f"Poisoned Bottle: {poisoned_bottle}")

# Create bottles and test strips
bottles = [Bottle(i) for i in range(num_bottles)]
test_strips = [TestStrip(i) for i in range(num_strips)]

# Find the poisoned bottle
result = find_poisoned_bottle(bottles, test_strips, poisoned_bottle)
print(f"Identified Bottle: {result}")
