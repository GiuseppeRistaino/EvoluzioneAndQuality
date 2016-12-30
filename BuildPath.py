
import os

ROOT_PATH="ProjectAnalysis\\"

def create_directory(finalPath,nameDirectory):
    newpath=finalPath+nameDirectory
    if not os.path.exists(newpath):
        os.makedirs(newpath)
    return newpath

def create_file(finalpath,nameFile):
    newpath=finalpath+nameFile
    file=open(newpath,'w')
    return file
