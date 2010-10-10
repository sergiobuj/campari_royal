#import <Foundation/Foundation.h>

extern float coseno();
extern float seno();
extern float tangente(int);
int main (int argc, const char * argv[]) {
    NSAutoreleasePool * pool = [[NSAutoreleasePool alloc] init];
	for(int angulo=90; angulo >= 0 ; scanf("%d",&angulo)){
		NSLog(@"seno %f coseno %f tangente %f",seno(angulo),coseno(angulo),tangente(angulo));		
	}
	[pool drain];
    return 0;
}
