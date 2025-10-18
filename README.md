# Discord Music Bot

A Spring Boot-based Discord music bot with LavaPlayer integration for playing music in voice channels.

## Features

- 🎵 Play music from various sources (YouTube, SoundCloud, etc.)
- 📋 Queue management with multiple tracks
- ⏭️ Skip tracks
- ⏹️ Stop music and clear queue
- 📊 View current queue
- 🏓 Ping command for bot status
- 🔧 Configurable audio settings
- 📝 Comprehensive logging

## Commands

- `/play <song>` - Play a song or add it to the queue
- `/skip` - Skip the current song
- `/stop` - Stop music and clear the queue
- `/queue` - Show the current queue
- `/ping` - Check bot status and latency

## Configuration

### Environment Variables

Set the following environment variable:
```bash
DISCORD_BOT_TOKEN=your_discord_bot_token_here
```

### Application Properties

The bot can be configured through `application.properties`:

```properties
# Discord Bot Configuration
discord.token=${DISCORD_BOT_TOKEN}

# Audio Configuration
audio.frame-buffer-duration=10000
audio.item-loader-thread-pool-size=10

# Logging Configuration
logging.level.com.discord.bot=INFO
logging.level.net.dv8tion.jda=WARN
logging.level.com.sedmelluq.discord.lavaplayer=WARN
```

## Setup

1. Clone the repository
2. Set your Discord bot token as an environment variable
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Architecture

### Key Components

- **JdaConfig**: Configures the Discord JDA client and registers slash commands
- **ChatMessageEventListener**: Handles slash command interactions
- **MusicService**: Manages music managers for different guilds
- **GuildMusicManager**: Manages audio player and scheduler for a specific guild
- **TrackScheduler**: Handles track queuing and playback
- **AudioConfig**: Configures LavaPlayer audio settings

### Improvements Made

1. **Enhanced Error Handling**: Added comprehensive error handling and logging throughout the application
2. **Command Structure**: Refactored to support multiple slash commands with proper validation
3. **Resource Management**: Added proper cleanup methods and shutdown hooks
4. **Configuration**: Made audio settings configurable through properties
5. **Logging**: Added structured logging with appropriate log levels
6. **Queue Management**: Enhanced queue functionality with detailed information display
7. **Code Organization**: Improved code structure and separation of concerns

## Dependencies

- Spring Boot 3.5.6
- JDA 5.0.0-beta.20 (Discord API)
- LavaPlayer 2.2.4 (Audio processing)
- Lombok (Code generation)

## Requirements

- Java 21+
- Maven 3.6+
- Discord Bot Token

## License

This project is for educational purposes.
