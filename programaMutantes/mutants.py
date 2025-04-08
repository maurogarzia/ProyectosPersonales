def is_mutant(dna):
    sum = comprobacion_horizontal(dna) + comprobacion_vertical(dna) + comprobacion_diagonal(dna) + comprobacion_diagonal_invertida(dna)
    if sum >= 2:
        return True
    else :
        return False
    

def comprobacion_vertical(matriz): #Funcion que transpone una matriz
    matrix_T = []
    for i in range(0,len(matriz[0])):
        new_row = []
        for z in matriz:
            new_row.append(z[i])
        matrix_T.append(''.join(new_row))
    return comprobacion_horizontal(matrix_T) #Llamo a la funcion comprobacion horizontal con la matriz transpuesta como parametro
        
    
    
    
def comprobacion_horizontal(matriz): # Comprueba que las filas tengas 4 o mas letras seguidas 
    counter = 0
    for i in matriz:
        for z in range(len(i) - 3):
            if i[z] == i[z+1] == i[z+2] == i[z+3]:
                counter += 1
    return counter


def case(diagonal):  #Funcion que verifica si se repiten letras
    #Contemplo que la lista pueda tener 4 elementos
    if len(diagonal) == 4:
        for z in diagonal:
            if diagonal[0] == diagonal[1] ==  diagonal[2] ==  diagonal[3]:
                return  True

    #Contemplo que la lista tenga 5 elementos
    elif len(diagonal) == 5:
        for z in diagonal:
            if diagonal[0] == diagonal[1] ==  diagonal[2] ==  diagonal[3]:
                return  True
            elif diagonal[1] == diagonal[2] ==  diagonal[3] ==  diagonal[4]:
                return  True
        
        #Contemplo que tenga 6 elementos 
    elif len(diagonal) == 6:
        for z in diagonal:
            if diagonal[0] == diagonal[1] ==  diagonal[2] ==  diagonal[3]:
                return  True
            elif diagonal[1] == diagonal[2] ==  diagonal[3] ==  diagonal[4]:
                return  True
            elif diagonal[2] == diagonal[3] ==  diagonal[4] ==  diagonal[5]:
                return True



def comprobacion_diagonal(matriz):#Funcion para encontrar las diagonales
    columns = len(matriz[0]) #Cuento cantidad de elementos por columna
    rows = len(matriz) #Cuento cantidad de elementos por fila
    count = 0

    #Bucle para saber las diagonales superiores a la principal
    for i in range(rows):
        diagonal = []
        for j in range(rows - i):
            diagonal.append(matrix[j][j + i])
        if case(diagonal) == True:
            count += 1

#Bucle para saber las diagonales inferiores a la principal

    for i in range(1, columns):
        diagonal = []
        for j in range(columns - i):
            diagonal.append(matrix[i + j][j])
        if case(diagonal) == True:
            count += 1
    
    return count

def comprobacion_diagonal_invertida(matriz):
    columns = len(matrix[0]) #Cuento cantidad de elementos por columna
    rows = len(matrix) #Cuento cantidad de elementos por fila
    count = 0

    #Bucle para saber las diagonales inferiores a la secundaria

    for i in range(rows - 1):
        diagonal = []
        for j in range(columns - i - 1):
            diagonal.append(matrix[rows - 1 - j][i + 1 + j])
        if case(diagonal) == True:
            count += 1

    #Bucle para saber diagonales superiores a la secundaria

    for i in range(rows - 1):
        diagonal = []
        for j in range(i + 1):
            diagonal.append(matrix[j][i - j])
        if case(diagonal) == True:
            count += 1

    #Bucle para saber la diagonal secundaria

    secondary_diagonal = []
    for i in range(min(rows, columns)):
        secondary_diagonal.append((matrix[i][i]))
    if case(secondary_diagonal) == True:
        count += 1

    return count

#MENU
option = '0' #Valor inicial para la condicion de salida del programa

while option != '1': #Cuando option sea 1 el programa finaliza

    print("Usuario, vamos a llenar tu secuencia de ADN, para ver si sos mutante: ")
    base = ['a','t','g','c','A','T','G','C'] #Letras de la base nitrogenada
    adn = ""
    matrix = []
    for i in range(0,6):

        print(f"\nVamos a llenar la secuencia {i + 1}: ")
        adn = ""
        for z in range(0,6):
            while True:
                sequence = input("\nIngrese la letra de la base nitrogenada (A,T,G,C):  ")

                #Valido que no se encuentren numeros en el arreglo
                if sequence.isdigit() == True:
                    print("No se deben ingresar valores numericos\n")
                    continue

                #Valido que no se ingresen mas de 6 caracteres
                if len(sequence) != 1  :
                    print("Se debe ingresar un solo caracter de adn\n")
                    continue
            
                #Valido que solo se pueda ingresar (A,T,G,C)
                elif sequence not in base:
                    print("Los valores ingresados no son correctos\n")
                    continue
                break   #Opcion de salida para la validacion en caso que se cumplan los requisitos

            sequence = sequence.upper() 
            adn = adn + sequence

        matrix.append(adn) #Agrego la secuencia de adn a la matriz
        print("")

    if is_mutant(matrix) == True:
    
        for i in matrix: #Muestro la matriz
            for z in i:
                print(z, end=" ")
            print(" ")
        print("\nMutante")
    else:

        for i in matrix: #Muestro la matriz
            for z in i:
                print(z, end=" ")
            print(" ")
        print("\nNo-Mutante")

    print("Desea volver a empezar?")
    print("Para salir ingrese 1\nPara volver a empezar ingrese cualquier otro boton: ")
    option = input()

print("HASTA LA PROXIMA !!")


'''
CASOS DE PRUEBA:

NO MUTANTE: 

matrix = ['AGTCCG','TCAGTA','CGTATC','ATCCAG','GCTAAT','ATGCCC'] 

MUTANTE: 

matrix = ['AGTCCG','TCAGTA','CGCATC','ATCCAG','AAAACT','ATGCCC']


'''