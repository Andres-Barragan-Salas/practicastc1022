/***********************************************
 * Andrés Barragan Salas: A01026567
 * Rodrigo Quiroz Reyes: A01026546
 * Esteban Manrique de Lara Sirvent: A01027077
 ***********************************************/

#include <linux/init.h>
#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/param.h>

/* This function is called when the module is loaded. */
int simple_init(void)
{
	printk(KERN_INFO "Loading Kernel Module\n");
	printk(KERN_INFO "%lu", HZ);

	return 0;
}

/* This function is called when the module is removed. */
void simple_exit(void)
{
	printk(KERN_INFO "Removing Kernel Module\n");
}

/* Macros for registering module entry and exit points. */
module_init(simple_init);
module_exit(simple_exit);

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple Module");
MODULE_AUTHOR("You know who");
