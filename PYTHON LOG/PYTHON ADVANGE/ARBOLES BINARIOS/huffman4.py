#!/usr/bin/env python3
import sys
import json
import pickle


def decode(dic, bitstr):
    res = []
    length = bitstr.bit_length() - 1
    if bitstr >> length != 1:
        raise Error("Corrupt file!")
    done = False
    while length > 0 and not done:
        shift = length - 1
        while True:
            num = bitstr >> shift
            bitnum = bin(num)[3:] 
            if bitnum not in dic:
                shift -= 1
                continue
            char = dic[bitnum]
            if char == 'end':
                done = True
                break
            res.append(char)
            bitstr = bitstr - ((num - 1) << shift)
            length = shift
    return ''.join(res)

if __name__ == "__main__":
    usage = """Usage: ./huffman_de.py infile outfile"""
    if len(sys.argv) < 3:
        print(usage)
        sys.exit(1)

    f = open(sys.argv[1]+".dic")
    dic = json.load(f)
    nwdic = {}
    for i,e in dic.items(): nwdic[e] = i
    f.close()

    f = open(sys.argv[1],'rb')
    bstr = pickle.load(f)
    f.close()

    content = decode(nwdic,bstr)

    f = open(sys.argv[2],'w')
    f.write(content)
    f.close()
    print("File decompressed!")