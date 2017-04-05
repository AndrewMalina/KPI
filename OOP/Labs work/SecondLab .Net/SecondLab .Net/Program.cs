using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//Title, CapsLock,Read, ReadLine, ReadKey, Write().

namespace SecondLab.Net
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Title = "SecondLab .Net";
            selectMenu();
            Console.Read();
        }
        static void selectMenu()
        {
            Console.WriteLine("Select the func whose description you want to know in .Net");
            Console.WriteLine("Menu : ");
            Console.WriteLine("1. Title");
            Console.WriteLine("2. Caps Lock ");
            Console.WriteLine("3. Read");
            Console.WriteLine("4. ReadKey");
            Console.WriteLine("5. Write()");
            Console.WriteLine("0. Exit the Program");
            int select = Convert.ToInt32(Console.ReadLine());
            switch (select)
            {
                case 1:
                    {
                        menuTitele();
                        break;
                    }
                case 2:
                    {
                        menuCapsLock();
                        break;
                    }
                case 3:
                    {
                        menuRead();
                        break;
                    }
                case 4:
                    {
                        menuReadKey();
                        break;
                    }
                case 5:
                    {
                        menuWrite();
                        break;
                    }
                case 0:
                    {
                        menuExit();
                        break;
                    }

            }
        }
        static void menuTitele()
        {
            Console.Clear();
            Console.WriteLine("Titele - nead for replace name of Console application");
            Console.WriteLine("Sample syntax is \"Console.Title = \"Name\";\"");
            Console.WriteLine("You can change name of this app.");
            Console.WriteLine("Select new Name : ");
            string newName = Console.ReadLine();
            Console.Title = newName;
            Console.WriteLine("You understend how work \"Titele\" now");
            Console.WriteLine("Enter 1 if you want return to menu or 0 if you want to exit the program");
            int answer = Convert.ToInt32(Console.ReadLine());
            if (answer == 1 )
            {
                Console.Clear();
                selectMenu();
            }
            if(answer == 0)
            {
                Console.Clear();
                menuExit();
            }
        }
        static void menuCapsLock() {
            Console.Clear();
            Console.WriteLine("Caps Lock - nead for return answer on or off key");
            Console.WriteLine("Sample syntax is \"Console.CapsLock;\"");
            Console.WriteLine("You can check turn on or turn off your Caps");
            Console.WriteLine("Press ENTER");
            Console.ReadLine();
            Console.WriteLine("Your caps = " + (Console.CapsLock==true ? "turn on":"turn off"));
            Console.WriteLine("You understend how work \"Caps Lock\" now");
            Console.WriteLine("Enter 1 if you want return to menu or 0 if you want to exit the program");
            int answer = Convert.ToInt32(Console.ReadLine());
            if (answer == 1)
            {
                Console.Clear();
                selectMenu();
            }
            if (answer == 0)
            {
                Console.Clear();
                menuExit();
            }
        }
        static void menuRead() {
            Console.Clear();
            Console.WriteLine("Read - Reads the next character from the standard input stream.");
            Console.WriteLine("Sample syntax is \"int example = Console.Read();\"");
            Console.WriteLine("You can see UNICODE of your character");
            int exampleRead = Console.Read();
            Console.WriteLine("Enter same character : " + exampleRead);
            Console.WriteLine("You understend how work \"Read\" now");
            Console.WriteLine("Enter 1 if you want return to menu or 0 if you want to exit the program");
            string a = Console.ReadLine();
            string b = Console.ReadLine();
            int answer = Convert.ToInt32(a);
            if (answer == 1)
            {
                Console.Clear();
                selectMenu();
            }
            if (answer == 0)
            {
                Console.Clear();
                menuExit();
            }
        }
        static void menuReadKey() {
            Console.Clear();
            Console.WriteLine("ReadKey - Gets the next user-pressed character or function key. The pressed key is displayed in the window");
            Console.WriteLine("Sample syntax is \"Console.ReadKey().Key != ConsoleKey.Enter\"");
            Console.WriteLine("You understend how work \"ReadKey\" now");
            Console.WriteLine("Enter 1 if you want return to menu or 0 if you want to exit the program");
            int answer = Convert.ToInt32(Console.ReadLine());
            if (answer == 1)
            {
                Console.Clear();
                selectMenu();
            }
            if (answer == 0)
            {
                Console.Clear();
                menuExit();
            }
        }
        static void menuWrite() {
            Console.Clear();
            Console.WriteLine("Write - output same var.");
            Console.WriteLine("Sample syntax is \"Console.Write();\"");
            Console.WriteLine("You can see your string just input it");
            string example = Console.ReadLine();
            Console.Write(example+"\n");
            Console.WriteLine("You understend how work \"Write\" now");
            Console.WriteLine("Enter 1 if you want return to menu or 0 if you want to exit the program");
            int answer = Convert.ToInt32(Console.ReadLine());
            if (answer == 1)
            {
                Console.Clear();
                selectMenu();
            }
            if (answer == 0)
            {
                Console.Clear();
                menuExit();
            }
        }
        static void menuExit() {
            Console.Clear();
            Environment.Exit(0);
        }
    }
}