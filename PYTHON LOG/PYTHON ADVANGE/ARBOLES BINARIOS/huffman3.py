import sys
import heapq
from collections import Counter
import pickle
import json

def get_probabilities(content):
    total = len(content) + 1 
    c = Counter(content)
    res = {}
    for char,count in c.items():
        res[char] = float(count)/total
    res['end'] = 1.0/total
    return res

def make_tree(probs):
    q = []
    for ch,pr in probs.items():
        heapq.heappush(q,(pr,0,ch))

    while len(q) > 1:
        e1 = heapq.heappop(q)
        e2 = heapq.heappop(q)
        nw_e = (e1[0]+e2[0],max(e1[1],e2[1])+1,[e1,e2])
        heapq.heappush(q,nw_e)
    return q[0]

def make_dictionary(tree):
    res = {}
    search_stack = []
    search_stack.append(tree+("",))
    while len(search_stack) > 0:
        elm = search_stack.pop()
        if type(elm[2]) == list:
            prefix = elm[-1]
            search_stack.append(elm[2][1]+(prefix+"0",))
            search_stack.append(elm[2][0]+(prefix+"1",))
            continue
        else:
            res[elm[2]] = elm[-1]
        pass
    return res

def compress(dic,content):
    res = ""
    for ch in content:
        code = dic[ch]
        res = res + code
    res = '1' + res + dic['end'] 
    res = res + (len(res) % 8 * "0") 
    return int(res,2)

def store(data,dic,outfile):

    outf = open(outfile,'wb')
    pickle.dump(compressed,outf)
    outf.close()

    outf = open(outfile+".dic",'w')
    json.dump(dic,outf)
    outf.close()
    pass

if __name__ == "__main__":
    usage = """Usage: ./huffman_en.py infile outfile"""

    if len(sys.argv) < 3:
        print(usage)
        sys.exit(1)

    inf = open(sys.argv[1])
    cont = inf.read()
    inf.close()


    probs = get_probabilities(cont)

    tree = make_tree(probs)
    

    dic = make_dictionary(tree)


    compressed = compress(dic,cont)
    store(compressed,dic,sys.argv[2])
    print("Archivo comprimido!")

for i in lista2:
	r = lista2[]