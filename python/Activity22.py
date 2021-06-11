import pytest

@pytest.mark.activity
def test_sum():
    num1 = 30
    num2 = 25
    sum = num1 + num2
    assert sum == 55
    print(sum)

def test_sub():
    num1 = 30
    num2 = 25
    diff = num1 - num2
    assert diff == 5 
    print(diff) 

def test_multiply():
    num1 = 5
    num2 = 6
    prod = num1 * num2
    assert prod == 30
    print(prod)

@pytest.mark.activity
def test_division():
    num1 = 10
    num2 = 5
    quot = num1/num2
    assert quot == 2
    print(quot)