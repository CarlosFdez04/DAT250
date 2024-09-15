<script>
  import { onMount } from "svelte";

  let polls = [];
  let selectedPoll = null;
  let voteOptions = [];
  let selectedOption = null;
  let responseMessage = "";

  // For creating polls
  let newPollQuestion = "";
  let newOptionText = "";
  let newOptions = [];

  // Fetch all polls
  function fetchPolls() {
    fetch('http://localhost:8080/polls')
      .then(response => response.json())
      .then(data => {
        polls = Object.values(data);
        console.log('Polls fetched:', polls);
      })
      .catch(error => {
        console.error('Error fetching polls:', error);
      });
  }

  // Create a new poll
  function createPoll() {
    if (!newPollQuestion || newOptions.length === 0) {
      responseMessage = "Poll question and options are required.";
      return;
    }

    fetch('http://localhost:8080/polls', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        question: newPollQuestion,
        options: newOptions
      }),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create poll');
        }
        return response.json();
      })
      .then(data => {
        responseMessage = "Poll created successfully!";
        newPollQuestion = "";
        newOptions = [];
        fetchPolls();  // Refresh the list of polls
        console.log('Poll created:', data);
      })
      .catch(error => {
        responseMessage = "Error creating poll.";
        console.error('Error:', error);
      });
  }

  // Add a new option to the poll
  function addOption() {
    if (newOptionText) {
      newOptions = [...newOptions, { text: newOptionText }];
      newOptionText = "";
    }
  }

  // Handle selecting a poll
  function selectPoll(poll) {
    selectedPoll = poll;
    voteOptions = poll.options || [];
  }

  // Submit a vote
  function vote(option) {
    if (selectedPoll && option) {
      fetch('http://localhost:8080/votes', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          pollId: selectedPoll.id,
          optionId: option.id
        }),
      })
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        responseMessage = "Vote submitted successfully!";
        console.log('Vote submitted:', data);
        fetchPolls(); // Refresh polls to reflect the new vote
      })
      .catch(error => {
        responseMessage = `Error submitting vote: ${error.message}`;
        console.error('Error:', error);
      });
    } else {
      responseMessage = "Please select a poll and an option before voting.";
    }
  }

  // Initialize the component
  onMount(() => {
    fetchPolls();
  });
</script>

<main>
  <h2>Polls</h2>

  {#if polls.length === 0}
    <p>No polls available.</p>
  {/if}

  <!-- Display Polls -->
  {#each polls as poll}
    <div class="poll" on:click={() => selectPoll(poll)}>
      <h3>{poll.question}</h3>
      {#if selectedPoll && selectedPoll.id === poll.id}
        <ul>
          {#each voteOptions as option}
            <li>
              <button on:click={() => vote(option)}>{option.text}</button>
            </li>
          {/each}
        </ul>
      {/if}
    </div>
  {/each}

  <!-- Create Poll Form -->
  <div class="create-poll">
    <h3>Create a New Poll</h3>
    <input
      type="text"
      placeholder="Poll question"
      bind:value={newPollQuestion}
    />
    <input
      type="text"
      placeholder="New option"
      bind:value={newOptionText}
    />
    <button on:click={addOption}>Add Option</button>
    <ul>
      {#each newOptions as option}
        <li>{option.text}</li>
      {/each}
    </ul>
    <button on:click={createPoll}>Create Poll</button>
  </div>

  <p>{responseMessage}</p>
</main>

<style>
  /* Add your styles here */
  .create-poll {
    margin-top: 20px;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
  }

  .create-poll input {
    display: block;
    margin-bottom: 10px;
    padding: 8px;
    width: 100%;
  }

  .create-poll button {
    padding: 8px 12px;
    margin-top: 10px;
    border: none;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border-radius: 4px;
  }

  .create-poll ul {
    list-style-type: none;
    padding: 0;
  }

  .create-poll li {
    margin-bottom: 5px;
  }

  .poll {
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 4px;
  }

  .poll button {
    padding: 8px 12px;
    margin: 5px 0;
    border: none;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border-radius: 4px;
  }
</style>
