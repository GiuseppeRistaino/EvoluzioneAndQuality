import os
import re
import BuildPath

DIR_CLASS="num_Class\\"
DIR_METHOD = "num_Method\\"


def getDotFiles(path):
    classList = []
    methods = []

    dotFiles = [os.path.join(root, name)
                for root, dirs, files in os.walk(path)
                for name in files
                if name.endswith(".dot")
                ]
    for el in dotFiles:
        nodeToPackage = {}
        assNodes = []
        file = open(el, 'r')
        for line in file:
            packageName = re.search('label="((\w+)\/)*(\w+)\.(\w+)"', line)
            if packageName is not None:
                methodName = re.search('__N', line)
                if methodName is not None:
                    matchMethod = re.search('(\w+)\.(\w+)', line)
                    method = matchMethod.group().rstrip(".")
                    #print("Metodo: " +str(method))
                    if method not in methods:
                        methods.append(method)
                else:
                    matchClass = re.search('(\w+)\.(\w+)', line)
                    classe = matchClass.group().rstrip(".").split(".")[0]
                    #print("Classe: " +str(classe))
                    if classe not in classList:
                        classList.append(classe)

        directory_method = projectPath + DIR_METHOD + release + "\\"
        BuildPath.create_directory(directory_method, "methods\\")

        fileClass = open(BuildPath.create_directory(projectPath,DIR_CLASS)+release +"-class.txt", 'w')

        for classe in classList:
            fileClass.write(classe + "\n")
            file = open(directory_method + "methods\\" + classe + "_methods.txt", 'w')
            for elem in methods:
                if classe == elem.split(".")[0]:
                    method = elem.split(".")[1]
                    file.write(method +"\n")


projectList = os.listdir(BuildPath.ROOT_PATH)

for project in projectList:
    projectPath = BuildPath.ROOT_PATH + project +"\\"
    releasePath = projectPath + "release\\"
    releaseList = os.listdir(releasePath)
    for release in releaseList:
        finalPath = releasePath + release+"\\html"
        print(finalPath)
        getDotFiles(finalPath)
