package assignment2_1.one;

class Television {
    private int channel;
    private boolean on;

    // setters
    public void setChannel(int channel) {
        if (!on) {
            return;
        }
        if (channel > 10) {
            channel -= 10;
        }
        this.channel = channel;
    }
    public void pressOnOff() {
        this.on = !this.on;
    }

    // getters
    public int getChannel() {
        return this.channel;
    }
    public boolean isOn() {
        return this.on;
    }
}

public class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}
