from multiprocessing import Pool

def func(x):
    return x*x

if __name__ == '__main__':
    with Pool(2) as p:
        print(p.map(func, [1, 2, 3]))