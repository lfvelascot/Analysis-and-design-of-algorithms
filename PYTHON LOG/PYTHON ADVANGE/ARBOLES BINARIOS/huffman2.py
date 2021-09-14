'''
    Algoritmo de Huffman
    Compresion de datos
'''
def huff():
	text = input("Put your text: ")
	let = dict()
	large1 = len(text)
	for i in range (large1):
		if text[i] in let:
			let[text[i]] += 1
		else:
			let[text[i]] = 1
	k = let.items()
	large2 = len(k)
	for i in range(large2):
		men = k[i][1] #menor
		for j in range(len(k)):
			if k[j][1] > men:
				men,let2 = k[j][1],k[j][0]
				a,b = k[i][1],k[i][0]
				k[j] = (b,a)
				k[i] = (let2,men)
	num = []
	lett = []
	comb = []
	for i in range(len(k)):
		num.append(k[i][1])
		lett.append(k[i][0])
		comb.append((k[i][0],0,0))
	tam = 0 

	size = len(num)
	while len(num) > 1:
		m = num[0]
		z = 0
		a = lett[0]
		for i in range(len(num)):
			if num[i] < m:
				m = num[i]
				a = lett[i]
				z = i
		lett.pop(z)
		num.pop(z)
		mini = num[0]
		j = 0
		b = lett[0]
		for i in range(len(num)):
			if num[i] < mini:
				mini = num[i]
				b = lett[i]
				j = i
		add = m + mini
		lett[j] = tam
		num[j] = add
		comb.append((tam,0,0))
		if m >= mini:
			counter = 1 
			con = 0
		else:
			counter = 0
			con = 1
		for q in range(len(comb)):
			if comb[q][0] == a:
				comb[q] = (a,counter,tam)
			if comb[q][0] == b:
				comb[q] = (b,con,tam)
		tam += 1

	num = []
	leng = len(comb)
	last = comb[leng-1][0]
	k = 0
	for i in range(size):
	    num.append([])
	    a,b,c = comb[i]
	    num[i].append(str(b))
	    q = i
	    cont = 0
	    while(q <= leng-2): 
	    	if(comb[q][0] == c):
	    		c = comb[q][2]
	    		num[i].append(str(comb[q][1]))
	    		cont = c
	    		if cont == last:
	    			break
	    	q += 1
	    num[i] =num[i][::-1]
	#Finish2-
	code = [] 
	for i in range(len(text)):
	    last = 0
	    while (last <= size):
	    	if comb[last][0] == text[i]:
	    		break
	    	last += 1
	    cads = "".join(num[last])
	    code.append((cads))

	#print "Code: ",code
	new = []

	for i in range(len(code)):
	    new.append(str(code[i]))
	new = "".join(new)
	cal = []
	j, k, i, l = 0,0,0,0 #another
	temp = []
	while(i < len(new)):
	    l = 1
	    j = 0
	    while(j < len(num) ):
	    	k = 0
	    	if new[i] == num[j][k]:
	    		k += 1
	    		if len(num[j]) == k:
	    			l = k
	    			temp.append(comb[j][0])
	    			while (k < len(num[j])):
	    				if new[i+k] == num[j][k]:
	    					k += 1
	    					if k == len(num[j]):
	    						temp.append(comb[j][0])
	    						l = k
	    				else:
	    					k = len(num[j])
	    	j += 1
	    i += l

	cade = "".join(temp)
	print ("Binary: ",new)
	print ("Code: ",code)
	print ("Translate: ",cade)

if __name__ == '__main__':
	huff()
