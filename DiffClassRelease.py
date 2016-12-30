import os
import os.path


def diffClassRelease(release1, release2):
    fileRelease1 = open(dir +"\\" + release1, 'r')
    fileRelease2 = open(dir +"\\" + release2, 'r')
    fileDiffClass = open("diffclass.txt", 'w')

    lineNumClassRelease1 = fileRelease1.readline()
    numClassRelease1 = lineNumClassRelease1.split(":")[1].strip()
    lineNumClassRelease2 = fileRelease2.readline()
    numClassRelease2 = lineNumClassRelease2.split(":")[1].strip()

    diffNumClass = int(numClassRelease1) - int(numClassRelease2)
    fileDiffClass.writelines(str(diffNumClass))

dir="classParsed"
fileparsed = os.listdir(dir)

numFile = 0
while numFile < len(fileparsed):
    if numFile+1 < len(fileparsed):
        diffClassRelease(fileparsed[numFile], fileparsed[numFile+1])
    numFile += 1
