#include <string>
#include <iostream>

using namespace std;

const char ultimas[] = "abcdefghijklmnopqrstuvwxyz";

int n(const char *s) {
	
	int len = strlen(s);
	if (len == 0) {
		return 0;
	} else if (len == 1) {
//		cout << "n(" << s[0] << ") = " << s[0] - 'a' + 1 << endl;
		return s[0] - 'a' + 1;
	} else {
		int result = 0;
		if (s[0] == 'a') {
			char tmp[len-1];
			strcpy(tmp, &(ultimas[sizeof(ultimas)-len]));
			result = n(tmp);
		} else {
			char tmp[len];
			strcpy(tmp, &ultimas[sizeof(ultimas)-len-1]);
			tmp[0] = s[0] - 1;
			result = n(tmp);
		}
		char tmp[len-1];
		strcpy(tmp,&s[1]);
		result += n(tmp);
		strncpy(tmp, &ultimas[s[0]+1-'a'], len-1);
		result -= n(tmp);
		result += 1;
//		cout << "n(" << s << ") = ";
//		if (s[0] == 'a') {
//			cout << "n(" << ultimas.substr(ultimas.size()-s.size()+1) << ") + ";
//		} else {
//			cout << "n(" << tmp << ") + ";
//		}
//		cout << "n(" << s.substr(1) << ") - ";
//		cout << "n(" << ultimas.substr(s[0]+1-'a',s.size()-1) << ") = " << result << endl;
		return result;
	}
}

int main() {
	
	string s;
	getline(cin,s); 	
	while (cin) {
		const char *dato = s.c_str();
		bool valido = true;
		for (unsigned int i = 0; i < strlen(dato)-1; i++) {
			valido &= dato[i] < dato[i+1];
		}
		if (valido) {
			cout << n(dato) << endl;
		} else { 
			cout << 0 << endl;
		}
		getline(cin,s);
	}
	return 0;
}
