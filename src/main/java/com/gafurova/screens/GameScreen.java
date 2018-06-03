package com.gafurova.screens;

import com.gafurova.engine.*;
import com.gafurova.entities.Enemy;
import com.gafurova.entities.Health;
import com.gafurova.entities.Laser;
import com.gafurova.entities.Player;
import com.gafurova.utils.GameContext;
import com.gafurova.engine.Intersector;
import com.gafurova.utils.StageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class GameScreen extends Screen {

    private Player player;

    private List<Enemy> enemies;
    private float enemyGenerateTime;
    private float enemyGeneratedLeftTime;

    private List<Laser> lasers;
    private float laserGenerateTime;
    private float laserGeneratedLeftTime;

    private Health health;
    private float healthGenerateTime;
    private float healthGeneratedLeftTime;

    private int killed;
    private int level;
    private Input input;

    @Autowired
    public GameScreen(Input input){
        this.input = input;
    }

    @Override
    public void onStart() {

        input.setScene(StageUtils.getInstance().getStage().getScene());


        Drawer.getInstance().draw(ResourcesHandler.getInstance().spaceBackground, 0, 0);

        player = new Player(ResourcesHandler.getInstance().spaceShip);
        player.setPosition(Drawer.getInstance().getWidth() / 2 - player.getSprite().getWidth() / 2, Drawer.getInstance().getHeight() - player.getSprite().getHeight() * 2);

        enemies = new ArrayList<>();
        enemyGenerateTime = 5;
        enemyGeneratedLeftTime = 0;

        lasers = new ArrayList<>();
        laserGenerateTime = 0.5f;
        laserGeneratedLeftTime = 0;

        healthGenerateTime = 10;
        healthGeneratedLeftTime = 0;

        killed = 0;
        level = 1;

        Drawer.getInstance().draw(player.getSprite());
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void onRender() {
        super.onRender();
        if(!inGame){
            return;
        }
        Drawer.getInstance().clear();
        Drawer.getInstance().draw(ResourcesHandler.getInstance().spaceBackground, 0, 0);

        if(player.health <= 0){
            onPause();
            System.out.println("Game Over!");
            return;
        }

        List<MonoBehaviour> monoBehaviours = GameContext.getInstance().getGame().monoBehaviours;
        for (int i = 0; i < monoBehaviours.size(); i++){
            MonoBehaviour instance = monoBehaviours.get(i);
            if(instance.enable){
                if(instance.destroy){
                    GameContext.getInstance().getGame().monoBehaviours.remove(instance);
                    continue;
                }
                Drawer.getInstance().draw(instance.getSprite());
                instance.update(deltaTime);
            }
        }

        if(input.getMouseX() < Drawer.getInstance().graphicsContext.getCanvas().getWidth() - player.getSprite().getWidth()) {
            player.setPosition(input.getMouseX(), player.getPositionY());
        }

        if (enemyGeneratedLeftTime > enemyGenerateTime){
            enemyGeneratedLeftTime = 0;
            generateEnemies();
        } else {
            enemyGeneratedLeftTime += deltaTime;
        }

        for(int e = 0; e < enemies.size(); e++){
            Enemy enemy = enemies.get(e);
            if(enemy.health <= 0){
                enemy.destroy();
                enemies.remove(enemy);
                killed++;
                System.out.println("Killed: " + killed);
                if(killed % 5 == 0){
                    level = killed / 5;
                    System.out.println("Level up!");
                }
            }
            else if(enemy.getPositionY() > 800){
                enemy.destroy();
                enemies.remove(enemy);
            } else {
                if(enemy.attack){
                    enemy.attack = false;
                    generateLaser(2, 2, enemy.getSprite());
                }
            }
        }

        laser:for(int l = 0; l < lasers.size(); l++){
            Laser laser = lasers.get(l);
            if(laser.getPositionY() + laser.getSprite().getHeight() < 0 || laser.getPositionY() > 800){
                laser.destroy();
                lasers.remove(laser);
            } else if(laser.getOwner() == 1) {
                for(int e = 0; e < enemies.size(); e++){
                    Enemy enemy = enemies.get(e);
                    if(Intersector.overlap(enemy.getSprite(), laser.getSprite())){
                        laser.destroy();
                        lasers.remove(laser);
                        enemy.health--;
                        continue laser;
                    }
                }
            } else if(laser.getOwner() == 2){
                if(Intersector.overlap(player.getSprite(), laser.getSprite())){
                    laser.destroy();
                    lasers.remove(laser);
                    player.health--;
                    System.out.println("Health: " + player.health);
                    continue laser;
                }
            }
        }

        if (laserGeneratedLeftTime > laserGenerateTime){
            laserGeneratedLeftTime = 0;
            generateLaser(1, 1, player.getSprite());
        } else {
            laserGeneratedLeftTime += deltaTime;
        }

        if(health == null && healthGeneratedLeftTime > healthGenerateTime){
            health = new Health();
            Random random = new Random();
            health.getSprite().setPosition(random.nextInt(500) + 50, - 50);
            healthGeneratedLeftTime = 0;
        } else if(health == null){
            healthGeneratedLeftTime += deltaTime;
        }

        if(health != null){
            if(Intersector.overlap(player.getSprite(), health.getSprite())){
                player.health = 5;
                System.out.println("Health up!");
                health.destroy();
                health = null;
            }
        }
    }

    private void generateLaser(int direction, int owner, Sprite sprite){
        Laser laser = new Laser(direction, owner);
        laser.setPosition(sprite.getX()
                + sprite.getWidth() / 2 - laser.getSprite().getWidth() / 2,
                sprite.getY());
        lasers.add(laser);
    }

    public void generateEnemies(){
        for(int i = 0; i < 6; i++){
            if(new Random().nextInt(3) + 1 > 2) {
                generateEnemy(i * 100);
            }
        }

    }

    private void generateEnemy(double x){
        Enemy enemy = new Enemy(ResourcesHandler.getInstance().enemyShip, level);
        enemy.setPosition(x,- 100);
        enemies.add(enemy);
    }

    @Override
    public void onClear() {
        super.onClear();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
