package com.javarush.test.level16.lesson07.task02;

/**
 * JavaRush.ru
 * Level 16, Lesson 07, Task 02
 * <p/>
 * Stopwatch (Секундомер).
 * 1. Разберись, что делает программа.
 * 2. Реализуйте логику метода doSeveralSteps так, чтобы учитывалась скорость бегуна.
 * 2.1 Метод getSpeed() в классе Runner показывает, сколько шагов в секунду делает бегун.
 * Нужно, чтобы бегун действительно делал заданное количество шагов в секунду.
 * Если Иванов делает 4 шага в секунду, то за 2 секунды он сделает 8 шагов.
 * Если Петров делает 2 шага в секунду, то за 2 секунды он сделает 4 шага.
 * 2.2 Метод sleep в классе Thread принимает параметр типа long.
 * <p/>
 * Date: 09.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static boolean isStopped = false;

    public static void main( String[] args ) throws InterruptedException
    {
        Runner ivanov = new Runner( "Ivanov", 4 );
        Runner petrov = new Runner( "Petrov", 2 );

        ivanov.start();
        petrov.start();
        Thread.sleep( 2000 );
        isStopped = true;
        Thread.sleep( 1000 );
    }

    public static class Stopwatch extends Thread
    {
        private Runner owner;
        private int stepNumber;

        public Stopwatch( Runner runner )
        {
            this.owner = runner;
        }

        @Override
        public void run()
        {
            try
            {
                while ( !isStopped )
                {
                    doSeveralSteps();
                }
            }
            catch ( InterruptedException e )
            {
            }
        }

        private void doSeveralSteps() throws InterruptedException
        {
            stepNumber++;
            System.out.println( owner.getName() + " делает шаг №" + stepNumber + "!" );
            Thread.sleep( ( long ) ( 1000 / owner.getSpeed() ) );
        }
    }

    public static class Runner
    {
        private String name;
        private double speed;
        Stopwatch stopwatch;

        public Runner( String name, double speed )
        {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch( this );
        }

        public String getName()
        {
            return name;
        }

        public double getSpeed()
        {
            return speed;
        }

        public void start()
        {
            stopwatch.start();
        }
    }
}
