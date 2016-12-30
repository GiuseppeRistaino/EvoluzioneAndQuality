import os,fnmatch

import BuildPath


def findFile(nameFile,releasepath):
    filesearch=None
    for path,dirs,files in os.walk(os.path.abspath(releasepath)):
        for filename in fnmatch.filter(files,nameFile):
            filesearch=os.path.join(path,filename)
    return filesearch

