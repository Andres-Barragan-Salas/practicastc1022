#include <stdlib.h>
#include <stdio.h>
#include <dirent.h>
#include <sys/stat.h>
#include <string.h>

int groupCount = 1;
int * groups;

void growGroupList(int groupNumber) {
	groups = realloc(groups, sizeof(int) * groupNumber);

	int * aux = groups + groupCount * sizeof(int);

	groupCount = groupNumber;

	int * last = groups + groupNumber * sizeof(int);

	for(; aux<last; aux += sizeof(int)) {
		*aux = 0;
	}
}

void filesBySizeIn(char * directoryPath) {
	struct stat info;
	struct dirent * directory;
	DIR * directoryStream;

	directoryStream = opendir(directoryPath);

	if (!directoryStream)
		return;

	while ((directory = readdir(directoryStream)) != NULL) {
		char path[1024];
		snprintf(path, sizeof(path), "%s/%s", directoryPath, directory->d_name);
		stat(path, &info);

		if (strcmp(directory->d_name, ".") !=0 && strcmp(directory->d_name, "..") !=0) {
			if (S_ISDIR(info.st_mode)) {
				filesBySizeIn(path);
			}
			else {
				int i = info.st_size/2048;
				if (i >= groupCount && groupCount < 5) {
					growGroupList(groupCount);
				}
				else if (i > 5){
					i = 5;
				}
				*(groups + i * sizeof(int)) = info.st_size;
			}
		}
	}

	closedir(directoryStream);
	return groups;
}

int main (int argc, char **argv) {
	groups = (int *)malloc(sizeof(int) * groupCount);
	growGroupList(1);

//	filesBySizeIn(".");
	growGroupList(4);

	int * aux = groups;
	int * last = groups + groupCount * sizeof(int);
	for (; aux < last; aux += sizeof(int)) {
		printf("%d\n", *aux);
	}

	free(groups);

	return 0;
}
