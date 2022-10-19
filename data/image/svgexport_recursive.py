import os
import subprocess as sp
import sys


def func(src):
    quality = "100%"
    extension = ".jpeg"
    data = dict()
    if not os.path.isdir(src):
        raise Exception("Error: %s Not a directory" % src)
    for filename in os.listdir(src):
        path = os.path.join(src, filename)
        if os.path.isfile(path):
            if path.endswith(".svg"):
                new_path = os.path.join(src,
                                        filename.split('.')[0] + extension)
                code = sp.run(["svgexport", path, new_path,
                               quality, extension]).returncode
                data[filename] = new_path + " | code: " + str(code)
        elif os.path.isdir(path):
            data_from_call = func(path)
            data.update(data_from_call)
    return data


def print_data(data):
    if type(data) != dict:
        raise Exception("Error: Wrong input")
    for k, v in data.items():
        print(k, v)


if __name__ == "__main__":
    data = func(sys.argv[1])
    print_data(data)
